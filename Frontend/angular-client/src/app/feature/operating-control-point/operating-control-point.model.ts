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

export class OperatingControlPointFormDto {
  id: number;
  pointName: string;
  loadingPoint: boolean;
  otherManager: boolean;
  platforms: PlatformOptionDto[];

  numberOfLines: number;
  discriminant: DiscriminantOptionDto;
  railwayDepartment: RailwayDepartmentOptionDto;
}

export class PlatformOptionDto {
 id: number;
 value: string;
}

export class RailwayDepartmentOptionDto {
  id: number;
  value: string;
}
export class DiscriminantOptionDto {
  id: number;
  value: string;
}
export class OperatingControlPointSearchCriteria {
  pointName: string;
  discriminantId: number | null;
  departmentId: number | null;
}
