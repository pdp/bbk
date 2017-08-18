import { BridgePage } from './app.po';

describe('bridge App', () => {
  let page: BridgePage;

  beforeEach(() => {
    page = new BridgePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
