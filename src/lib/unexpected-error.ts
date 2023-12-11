import {messages} from './messages';

const getRandom = () => Math.round(Math.random() * 50);
const shouldThrow = () => getRandom() === getRandom();

export const WaterLeakage = () => {
  if (shouldThrow()) throw new Error(messages['error:water-leakage']);
};

export const suddenShutdown = () => {
  if (shouldThrow()) throw new Error(messages['error:no-electricity']);
};
