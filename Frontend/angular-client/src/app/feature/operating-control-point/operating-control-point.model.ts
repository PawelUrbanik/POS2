export interface OperatingControlPointRowDto {
  id: number;
  pointName: string;
  loadingPoint: boolean;
  otherManager: boolean;
  numberOfPlatforms: number;
  discriminant: string;
  railwayDepartment: string;
}

export interface OperatingControlPointResponse {
  content: OperatingControlPointRowDto[];
  totalElements: number;
}
