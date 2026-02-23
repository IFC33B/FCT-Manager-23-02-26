export interface Tutor {
  id?: number;
  nom: string;
  cognom: string;
  email: string;
  telefon: string;
  carrec: string;
  tipus: 'EMPRESA' | 'CENTRE';
  empresa?: { id: number; nom: string };
}
