import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscriminantListComponent } from './discriminant-list.component';

describe('DiscriminantListComponent', () => {
  let component: DiscriminantListComponent;
  let fixture: ComponentFixture<DiscriminantListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscriminantListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscriminantListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
