import {Edge} from "../edge/edge.model";

export interface Platform {
  id: number;
  platformNumber: string;
  height: number;
  length: number;
  requestStop: boolean;
  edges?: Edge[];
}
