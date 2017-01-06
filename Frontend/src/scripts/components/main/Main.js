import './main.scss';

import React, { Component, PropTypes } from 'react';
import classnames from 'classnames';
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

export default class Main extends Component {
  static contextTypes = {
    router: PropTypes.object,
  };

  static propTypes = {
    children: PropTypes.object,
  };

  renderMenuItems() {
    const {
      router,
    } = this.context;

    return (
      map(menu, (key, value) => {
        const isActive = router.isActive(key);

        return (
          <ListItem
            selectable
            caption={ value }
            className={ classnames({ active: isActive }) }
            key={ key }
            onClick={ () => { router.push(key); } }
          />
        );
      })
    );
  }

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
            { this.renderMenuItems() }
          </List>
        </aside>
        <article className="content">
          { this.props.children ? this.props.children : null }
        </article>
      </div>
    );
  }
}