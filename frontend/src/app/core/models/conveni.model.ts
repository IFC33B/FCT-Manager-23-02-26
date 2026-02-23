export interface Conveni {
  id?: number;
  alumne: { id: number; nom: string; cognom: string };
  empresa: { id: number; nom: string };
  tutorEmpresa: { id: number; nom: string; cognom: string };
  tutorCentre: { id: number; nom: string; cognom: string };
  dataInici: string;
  dataFi: string;
  horesTotals: number;
  estat: 'PENDENT' | 'ACTIU' | 'FINALITZAT' | 'CANCEL\u00b7LAT';
  observacions: string;
}
