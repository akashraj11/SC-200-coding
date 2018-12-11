import { FileExplorerModule } from './file-explorer.module';

describe('FileExplorerModule', () => {
  let fileExplorerModule: FileExplorerModule;

  beforeEach(() => {
    fileExplorerModule = new FileExplorerModule();
  });

  it('should create an instance', () => {
    expect(fileExplorerModule).toBeTruthy();
  });
});
