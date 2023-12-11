import * as fs from 'fs';

export const show = (
  path: string,
  toReplace?: string[],
  toReplaceLength?: number
) => {
  const filePath = `./assets/${path}`;
  let fileContent = fs.readFileSync(filePath, 'utf-8');

  const replacePattern = 'xxx';
  const repeatPattern = '═';

  if (toReplace) {
    toReplace.forEach(value => {
      fileContent = fileContent.replace(replacePattern, value);
    });
    fileContent = fileContent.replace(
      replacePattern,
      repeatPattern.repeat(toReplaceLength || toReplace[0].length)
    );
  }

  console.log(fileContent);
};
