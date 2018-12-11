import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommedationCardComponent } from './recommedation-card.component';

describe('RecommedationCardComponent', () => {
  let component: RecommedationCardComponent;
  let fixture: ComponentFixture<RecommedationCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecommedationCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecommedationCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
