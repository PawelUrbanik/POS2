import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscriminantComponent } from './discriminant.component';

describe('DiscriminantComponent', () => {
  let component: DiscriminantComponent;
  let fixture: ComponentFixture<DiscriminantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscriminantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DiscriminantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
