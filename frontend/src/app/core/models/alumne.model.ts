import { Cicle } from './cicle.model';

export interface Alumne {
  id?: number;
  nom: string;
  cognom: string;
  dni: string;
  email: string;
  telefon: string;
  poblacio: string;
  cursEscolar: string;
  cicle: Cicle;
}
