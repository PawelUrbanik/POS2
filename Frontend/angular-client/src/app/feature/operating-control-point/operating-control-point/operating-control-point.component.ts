import {Component, OnInit} from '@angular/core';
import {OperatingControlPointService} from "../operating-control-point.service";
import {OperatingControlPointDatasource} from "../operating-control-point-list/operating-control-point-datasource";
import {OperatingControlPointSearchCriteria} from "../operating-control-point.model";

@Component({
  selector: 'app-operating-control-point',
  templateUrl: './operating-control-point.component.html',
  styleUrls: ['./operating-control-point.component.css']
})
export class OperatingControlPointComponent implements OnInit {

  dataSource: OperatingControlPointDatasource;

  constructor(private service: OperatingControlPointService) {
    this.dataSource = new OperatingControlPointDatasource(this.service);
    this.dataSource.loadPoints();
  }

  ngOnInit(): void {
  }


}
