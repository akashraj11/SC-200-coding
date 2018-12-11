import { HttpClient } from '@angular/common/http';
import { Component, Input, Output, EventEmitter, Injectable } from '@angular/core';
import { FileElement } from './model/file-element';
import { MatMenuTrigger } from '@angular/material/menu';
import { MatDialog } from '@angular/material/dialog';
import { NewFolderDialogComponent } from './modals/new-folder-dialog/new-folder-dialog.component';
import { RenameDialogComponent } from './modals/rename-dialog/rename-dialog.component';
import { NewFileDialogComponent } from './modals/new-file-dialog/new-file-dialog.component';
import { Router, ActivatedRoute,NavigationEnd } from '@angular/router';
import { FileService } from './file.service';
import { SelectionModel } from '@angular/cdk/collections';
import { FlatTreeControl } from '@angular/cdk/tree';
import { MatTreeFlattener, MatTreeFlatDataSource } from '@angular/material/tree';
import { of as ofObservable, Observable, BehaviorSubject } from 'rxjs';
import { FilesService } from '../../files.service';
import { environment } from '../../../../environments/environment';

/**
 * Node for to-do item
 */
export class TodoItemNode {
  children: TodoItemNode[];
  item: string;
}

/** Flat to-do item node with expandable and level information */
export class TodoItemFlatNode {
  item: string;
  level: number;
  expandable: boolean;
}

/**
 * The Json object for to-do list data.
 */
// const TREE_DATA = {'root': {'a':{'b': {'d': {'c': {'HelloWorld.java' : null}}}, 'd':{'e':{'HelloWorld.java' : null}}}, 'c':{'HelloWorld.java' : null}}};

@Injectable()
export class ChecklistDatabase {
  dataChange: BehaviorSubject<TodoItemNode[]> = new BehaviorSubject<TodoItemNode[]>([]);
  public url = environment.apiUrl + 'file/structure';
  public TREE: string;

  constructor(private http: HttpClient, private fileService: FileService) {
    // this.initialize();
  }

  get data(): TodoItemNode[] { return this.dataChange.value; }

  initialize() {
    // Build the tree nodes from Json object. The result is a list of `TodoItemNode` with nested
    //     file node as children.
    this.TREE = this.fileService.getFileStructure().toString();
    //console.log(this.TREE);
    this.TREE = this.TREE.replace(/'/g, '\"');
    //console.log(this.TREE);
    this.TREE = JSON.parse(this.TREE);
    //this.TREE = {'root':{'test':{'ArrayDifference.js' : null, 'ArrayDifference2.js' : null}}, 'test':{'test2':{'ArrayDifference.js' : null}}};

    const values = this.buildFileTree(this.TREE, 0);
    // Notify the change.
    this.dataChange.next(values);
    // pipe(map(response => response.toString()))

  }

  /**
   * Build the file structure tree. The `value` is the Json object, or a sub-tree of a Json object.
   * The return value is the list of `TodoItemNode`.
   */
  buildFileTree(value: any, level: number) {
    const data: any[] = [];
    for (const k in value) {
      const v = value[k];
      const node = new TodoItemNode();
      node.item = `${k}`;
      if (v === null || v === undefined) {
        // no action
      } else if (typeof v === 'object') {
        node.children = this.buildFileTree(v, level + 1);
      } else {
        node.item = v;
      }
      data.push(node);
    }
    return data;
  }

  /** Add an item to to-do list */
  insertItem(parent: TodoItemNode, name: string) {
    const child = <TodoItemNode>{ item: name };
    if (parent.children) {
      parent.children.push(child);
      this.dataChange.next(this.data);
    }
  }

  updateItem(node: TodoItemNode, name: string) {
    node.item = name;
    this.dataChange.next(this.data);
  }
}

@Component({
  selector: 'app-directory',
  templateUrl: './directory.component.html',
  styleUrls: ['./directory.component.css'],
  providers: [ChecklistDatabase]
})
export class DirectoryComponent {
  id: string;
  count:number=0;

  /** Map from flat node to nested node. This helps us finding the nested node to be modified */
  flatNodeMap: Map<TodoItemFlatNode, TodoItemNode> = new Map<TodoItemFlatNode, TodoItemNode>();

  /** Map from nested node to flattened node. This helps us to keep the same object for selection */
  nestedNodeMap: Map<TodoItemNode, TodoItemFlatNode> = new Map<TodoItemNode, TodoItemFlatNode>();

  /** A selected parent node to be inserted */
  selectedParent: TodoItemFlatNode | null = null;

  /** The new item's name */
  newItemName: string = '';

  treeControl: FlatTreeControl<TodoItemFlatNode>;

  treeFlattener: MatTreeFlattener<TodoItemNode, TodoItemFlatNode>;

  dataSource: MatTreeFlatDataSource<TodoItemNode, TodoItemFlatNode>;

  /** The selection for checklist */
  checklistSelection = new SelectionModel<TodoItemFlatNode>(true /* multiple */);

  @Input() fileElements: FileElement[];
  @Input() canNavigateUp: string;
  @Input() path: string;
  @Output() folderAdded = new EventEmitter<{ name: string }>();
  @Output() elementRemoved = new EventEmitter<FileElement>();
  @Output() elementRenamed = new EventEmitter<FileElement>();
  @Output() elementMoved = new EventEmitter<{ element: FileElement; moveTo: FileElement }>();
  @Output() navigatedDown = new EventEmitter<FileElement>();
  @Output() navigatedUp = new EventEmitter();
  @Output() fileAdded = new EventEmitter<{ name: string }>();
  @Output() clickedFile: EventEmitter<string> = new EventEmitter();
  @Input() userName: string;
  @Input() challengeId: string;

  constructor(public dialog: MatDialog, private router: Router, private fileService: FileService, private database: ChecklistDatabase, private filesService: FilesService, private route: ActivatedRoute) {
    this.treeFlattener = new MatTreeFlattener(this.transformer, this.getLevel,
      this.isExpandable, this.getChildren);
    this.treeControl = new FlatTreeControl<TodoItemFlatNode>(this.getLevel, this.isExpandable);
    this.dataSource = new MatTreeFlatDataSource(this.treeControl, this.treeFlattener);

    database.dataChange.subscribe(data => {
      this.dataSource.data = data;
    });
  }

   showDirectory() {
     this.database.initialize();
  }

  showTemplate() {
    console.log(this.challengeId + ' ' + this.userName);
    this.filesService.getTemplate("Template/" + this.challengeId).subscribe(data => {
      this.filesService.allFiles = data['paths'];
      this.filesService.fileContent = data['contents'];
      console.log(data['paths']);
      this.database.initialize();
    });
  }

  deleteElement(element: FileElement) {
    this.elementRemoved.emit(element);
  }

  // showContent(name: string) {
  //   console.log("showContent method is being called");

  //   this.id = this.route.snapshot.paramMap.get('id');
  //   var filename = name.split('.');
  //   //this.router.navigate(['attempt/' + this.id + '/' + filename[1] + '/' + filename[0]]);
  // }

  showContent(name:string){
    console.log("content from directory component");
    // this.filesService.getContentfromUrl(name).subscribe(data=>{
    //   console.log("data is " ,data );
    console.log(name);
    this.clickedFile.emit(name);
    //this.callOnClicked.emit(null);    //this.fileService.changeMessage(name);
    //this.fileService.setClickedFileName(name);
    
//        var filename = name.split('.');
//       this.id = this.route.snapshot.paramMap.get('id');

//     //   this.filesService.testData="";
//     //   this.filesService.testData=data['content'];
     
//     //   console.log("url from the route");
//     //   console.log(this.router.url);
// console.log(this.router.url);

// if(this.count<1){
//   this.count++;
//       this.router.navigate(['attempt/' + this.id + '/' + filename[1] + '/' + filename[0]]);
//       }
//       else{
//         this.count++;
//         console.log(this.count);
//         this.id=this.route.snapshot.paramMap.get('id');

//       console.log(this.id);
        
//       console.log(this.router.url);
     
//        //this.router.navigate(['/attempt'+this.id],{)
//         this.router.navigateByUrl('/attempt/'+this.id+'/'+filename[1]+'/'+filename[0]);
//       }      

  }

  // navigate(element: FileElement) {
  //   if (element.isFolder) {
  //     this.navigatedDown.emit(element);
  //   } else {
  //     const names = element.name.split('.');
  //     this.router.navigate(['/' + names[1] + '/' + names[0]]);
  //   }
  // }

  navigateUp() {
    this.router.navigate(['']);
    this.navigatedUp.emit();
  }

  moveElement(element: FileElement, moveTo: FileElement) {
    this.elementMoved.emit({ element: element, moveTo: moveTo });
  }

  openNewFolderDialog() {
    const dialogRef = this.dialog.open(NewFolderDialogComponent);
    dialogRef.afterClosed().subscribe(res => {
      console.log(res);
      if (res) {
        this.folderAdded.emit({ name: res });
      }
    });
  }
  openNewFileDialog() {
    const dialogRef1 = this.dialog.open(NewFileDialogComponent);
    dialogRef1.afterClosed().subscribe(res => {
      // console.log(res);
      if (res) {
        this.fileAdded.emit({ name: res });
        // console.log("files added");
      }
    });
  }

  openRenameDialog(element: FileElement) {
    const dialogRef = this.dialog.open(RenameDialogComponent);
    dialogRef.afterClosed().subscribe(res => {
      if (res) {
        element.name = res;
        this.elementRenamed.emit(element);
      }
    });
  }

  openMenu(event: MouseEvent, viewChild: MatMenuTrigger) {
    event.preventDefault();
    viewChild.openMenu();
  }

  // directory structure code starts

  getLevel = (node: TodoItemFlatNode) => { return node.level; };

  isExpandable = (node: TodoItemFlatNode) => { return node.expandable; };

  getChildren = (node: TodoItemNode): Observable<TodoItemNode[]> => {
    return ofObservable(node.children);
  }

  hasChild = (_: number, _nodeData: TodoItemFlatNode) => { return _nodeData.expandable; };

  hasNoContent = (_: number, _nodeData: TodoItemFlatNode) => { return _nodeData.item === ''; };

  /**
   * Transformer to convert nested node to flat node. Record the nodes in maps for later use.
   */
  transformer = (node: TodoItemNode, level: number) => {
    let flatNode = this.nestedNodeMap.has(node) && this.nestedNodeMap.get(node)!.item === node.item
      ? this.nestedNodeMap.get(node)!
      : new TodoItemFlatNode();
    flatNode.item = node.item;
    flatNode.level = level;
    flatNode.expandable = !!node.children;
    this.flatNodeMap.set(flatNode, node);
    this.nestedNodeMap.set(node, flatNode);
    return flatNode;
  }

  /** Whether all the descendants of the node are selected */
  descendantsAllSelected(node: TodoItemFlatNode): boolean {
    const descendants = this.treeControl.getDescendants(node);
    return descendants.every(child => this.checklistSelection.isSelected(child));
  }

  /** Whether part of the descendants are selected */
  descendantsPartiallySelected(node: TodoItemFlatNode): boolean {
    const descendants = this.treeControl.getDescendants(node);
    const result = descendants.some(child => this.checklistSelection.isSelected(child));
    return result && !this.descendantsAllSelected(node);
  }

  /** Toggle the to-do item selection. Select/deselect all the descendants node */
  todoItemSelectionToggle(node: TodoItemFlatNode): void {
    this.checklistSelection.toggle(node);
    const descendants = this.treeControl.getDescendants(node);
    this.checklistSelection.isSelected(node)
      ? this.checklistSelection.select(...descendants)
      : this.checklistSelection.deselect(...descendants);
  }

  /** Select the category so we can insert the new item. */
  addNewItem(node: TodoItemFlatNode) {
    const parentNode = this.flatNodeMap.get(node);
    this.database.insertItem(parentNode!, '');
    this.treeControl.expand(node);
  }

  /** Save the node to database */
  saveNode(node: TodoItemFlatNode, itemValue: string) {
    const nestedNode = this.flatNodeMap.get(node);
    this.database.updateItem(nestedNode!, itemValue);
  }

}
