import {WaterLeakage, messages} from '../lib';

export class RiceCooker {
  private maxCupNumber = 10;
  private waterCupNumber = 0;
  private riceCupNumber = 0;
  private plug = false;
  private power = false;

  constructor() {}

  public addWater(cups: number) {
    WaterLeakage();
    if (this.waterCupNumber + this.riceCupNumber + cups > this.maxCupNumber) {
      throw new Error(messages['error:max-capacity']);
    }
    this.waterCupNumber += cups;
  }

  public addRice(cups: number) {
    if (this.waterCupNumber + this.riceCupNumber + cups > this.maxCupNumber) {
      throw new Error(messages['error:max-capacity']);
    }
    this.riceCupNumber += cups;
  }

  public removeWater(cups: number) {
    if (this.waterCupNumber < cups) {
      throw new Error(messages['error:not-enough-water']);
    }
    this.waterCupNumber -= cups;
  }

  public discardRice(cups: number) {
    if (this.riceCupNumber < cups) {
      throw new Error(messages['error:not-enough-rice']);
    }
    this.riceCupNumber -= cups;
  }

  public togglePlug() {
    const magicNumber = Math.round(Math.random() * 100);
    if (magicNumber > 48 && magicNumber < 52) {
      throw new Error(messages['error:plug-explosion']);
    }
    this.plug = !this.power;
  }

  public togglePower() {
    if (!this.plug) {
      throw new Error(messages['error:power-not-plugged']);
    }
    this.power = !this.power;
  }

  public getWaterCupNumber = () => this.waterCupNumber;
  public getRiceCupNumber = () => this.riceCupNumber;
  public getPlug = () => this.plug;
  public getPower = () => this.power;
}
