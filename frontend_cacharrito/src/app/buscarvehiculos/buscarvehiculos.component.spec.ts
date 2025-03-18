import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarvehiculosComponent } from './buscarvehiculos.component';

describe('BuscarvehiculosComponent', () => {
  let component: BuscarvehiculosComponent;
  let fixture: ComponentFixture<BuscarvehiculosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuscarvehiculosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuscarvehiculosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
