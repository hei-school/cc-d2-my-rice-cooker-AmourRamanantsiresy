import {show} from './show';
import {templates} from './templates';

/* eslint-disable node/no-unsupported-features/node-builtins */
export const banner = () => {
  console.clear();
  show(templates.banner);
};
