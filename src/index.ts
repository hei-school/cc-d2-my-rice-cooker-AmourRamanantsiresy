import {RiceCooker} from './classes/RiceCooker';
import {banner, input, messages, show, suddenShutdown, templates} from './lib';
import {validateNumber} from './lib/validator';

const plugHandler = (rc: RiceCooker) => {
  const title = !rc.getPlug() ? 'Plug' : 'Unplug';
  show(templates.title, [title]);
  rc.togglePlug();
  show(templates.simple_result, ['Done'], title.length);
};

const powerHandler = (rc: RiceCooker) => {
  const title = !rc.getPower() ? 'Power on' : 'Power off';
  show(templates.title, [title]);
  rc.togglePower();
  show(templates.simple_result, ['Done !'], title.length);
};

const addWaterHandler = async (rc: RiceCooker) => {
  const title = 'Add water cups.';
  show(templates.title, [title]);
  const cups = await input('Number of cups of water you want to add : ');
  validateNumber(cups);
  rc.addWater(+cups);
  show(templates.simple_result, ['Done !'], title.length);
};

const addRiceHandler = async (rc: RiceCooker) => {
  const title = 'Add Rice cups.';
  show(templates.title, [title]);
  const cups = await input('Number of cups of rice you want to add : ');
  validateNumber(cups);
  rc.addRice(+cups);
  show(templates.simple_result, ['Done !'], title.length);
};

const removeWaterHandler = async (rc: RiceCooker) => {
  const title = 'Remove water cups.';
  show(templates.title, [title]);
  const cups = await input('Number of cups of water you want to remove : ');
  validateNumber(cups);
  rc.removeWater(+cups);
  show(templates.simple_result, ['Done !'], title.length);
};

const discardRiceHandler = async (rc: RiceCooker) => {
  const title = 'Discard Rice cups.';
  show(templates.title, [title]);
  const cups = await input('Number of cups of rice you want to discard : ');
  validateNumber(cups);
  rc.discardRice(+cups);
  show(templates.simple_result, ['Done !'], title.length);
};

const handler = async (rc: RiceCooker) => {
  suddenShutdown();
  show(templates.menu, [
    rc.getWaterCupNumber().toString(),
    rc.getRiceCupNumber().toString(),
    rc.getPlug() ? 'Plugged' : 'Unplugged',
    rc.getPower() ? 'On' : 'Off',
  ]);
  const choice = await input('=> ');

  if (choice === '1') plugHandler(rc);
  else if (choice === '2') powerHandler(rc);
  else if (choice === '3') await addWaterHandler(rc);
  else if (choice === '4') await addRiceHandler(rc);
  else if (choice === '5') await removeWaterHandler(rc);
  else if (choice === '6') await discardRiceHandler(rc);
  else if (choice === '7') throw Error(messages['kill:quite']);
  else throw new Error(messages['error:bad-choice']);
};

const main = async () => {
  let run = true;

  const riceCooker = new RiceCooker();

  while (run) {
    banner();

    try {
      await handler(riceCooker);
    } catch (err) {
      const error = err as Error;
      if (error.message.includes('kill')) {
        run = false;
      } else {
        show(templates.error, [error.message]);
      }
    }
    await input('Type enter to continue.');
  }
};

main();
