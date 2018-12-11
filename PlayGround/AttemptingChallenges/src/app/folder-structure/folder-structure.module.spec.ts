import { FolderStructureModule } from './folder-structure.module';

describe('FolderStructureModule', () => {
  let folderStructureModule: FolderStructureModule;

  beforeEach(() => {
    folderStructureModule = new FolderStructureModule();
  });

  it('should create an instance', () => {
    expect(folderStructureModule).toBeTruthy();
  });
});
