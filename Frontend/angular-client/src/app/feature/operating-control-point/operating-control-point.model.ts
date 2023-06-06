export class OperatingControlPointRowDto {
  id: number;
  pointName: string;
  loadingPoint: boolean;
  otherManager: boolean;
  numberOfPlatforms: number;

  numberOfLines: number;
  discriminant: string;
  railwayDepartment: string;
}

export interface OperatingControlPointResponse {
  content: OperatingControlPointRowDto[];
  totalElements: number;
}
