import { registerPlugin } from '@capacitor/core';

import type { ZipPlugin } from './definitions';

const Zip = registerPlugin<ZipPlugin>('Zip', {
  web: () => import('./web').then(m => new m.ZipPluginWeb()),
});

export * from './definitions';
export { Zip };
