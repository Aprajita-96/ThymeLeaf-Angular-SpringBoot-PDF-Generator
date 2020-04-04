import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrailJsComponent } from './trail-js.component';

describe('TrailJsComponent', () => {
  let component: TrailJsComponent;
  let fixture: ComponentFixture<TrailJsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrailJsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrailJsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
