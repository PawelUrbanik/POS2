import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscriminantFormComponent } from './discriminant-form.component';

describe('DiscriminantFormComponent', () => {
  let component: DiscriminantFormComponent;
  let fixture: ComponentFixture<DiscriminantFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscriminantFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DiscriminantFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
