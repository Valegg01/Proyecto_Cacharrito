import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionvehiculosComponent } from './gestionvehiculos.component';

describe('GestionvehiculosComponent', () => {
  let component: GestionvehiculosComponent;
  let fixture: ComponentFixture<GestionvehiculosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestionvehiculosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestionvehiculosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
