import './main.scss';

import React, { Component } from 'react';
import { map } from 'lodash';

import paths from 'consts/paths';

import {
  AppBar,
  List,
  ListItem,
} from 'ui';

const menu = {
  'Movie Rentals': paths.movieRentals,
};

const menuItems = map(menu, (key, value) => {
  return (
    <ListItem
      selectable
      caption={ value }
      key={ key }
    />
  );
});

export default class Main extends Component {
  render() {
    return (
      <div className="root">
        <AppBar leftIcon="menu"
          title="Movie Rental"
        />
        <aside className="navigation">
          <List
            ripple
            selecteable
            className="list"
          >
            { menuItems }
          </List>
        </aside>
        test
      </div>
    );
  }
}