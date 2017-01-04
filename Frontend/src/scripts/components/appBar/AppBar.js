import React, { Component } from 'react';

import AppBar from 'react-toolbox/lib/app_bar';
import Navigation from 'react-toolbox/lib/navigation';
import Link from 'react-toolbox/lib/Link';

export default class App extends Component {
  return() {
    <AppBar title='Movie Rental'>
      <Navigation type='horizontal'>
        <Link href="" label="" />
        <Link href="" label="" />
      </Navigation>
    </AppBar>
  }
}