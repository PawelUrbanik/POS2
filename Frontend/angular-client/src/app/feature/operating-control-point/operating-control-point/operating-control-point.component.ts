import {Component, OnInit} from '@angular/core';
import {OperatingControlPointService} from "../operating-control-point.service";

@Component({
  selector: 'app-operating-control-point',
  templateUrl: './operating-control-point.component.html',
  styleUrls: ['./operating-control-point.component.css']
})
export class OperatingControlPointComponent implements OnInit {


  constructor(private service: OperatingControlPointService) { }

  ngOnInit(): void {
  }


}
