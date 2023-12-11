import {messages} from '../messages';

export const validateNumber = (str: string) => {
  if (isNaN(+str)) {
    throw new Error(messages['error:bad-input-value']);
  }
};
