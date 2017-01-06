import React, { Component } from 'react';

import {
  AppBar,
  Navigation,
  Link,
} from 'ui';

export default class App extends Component {
  render() {
    return (
      <AppBar leftIcon="menu"
        title="Movie Rental"
      >
        <Navigation type="horizontal">
          <Link href="/"
            icon="inbox"
            label="Test"
          />
        </Navigation>
      </AppBar>
    );
  }
}