import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OperatingControlPointComponent } from './operating-control-point.component';

describe('OperatingControlPointComponent', () => {
  let component: OperatingControlPointComponent;
  let fixture: ComponentFixture<OperatingControlPointComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OperatingControlPointComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OperatingControlPointComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
