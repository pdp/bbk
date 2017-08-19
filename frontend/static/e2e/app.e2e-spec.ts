import { BridgePage } from './app.po';

describe('bridge App', function() {
  let page: BridgePage;

  beforeEach(() => {
    page = new BridgePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
