import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompileTriggerComponent } from './compile-trigger.component';

describe('CompileTriggerComponent', () => {
  let component: CompileTriggerComponent;
  let fixture: ComponentFixture<CompileTriggerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompileTriggerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompileTriggerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
