import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OperatingControlPointListComponent } from './operating-control-point-list.component';

describe('OperatingControlPointListComponent', () => {
  let component: OperatingControlPointListComponent;
  let fixture: ComponentFixture<OperatingControlPointListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OperatingControlPointListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OperatingControlPointListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
