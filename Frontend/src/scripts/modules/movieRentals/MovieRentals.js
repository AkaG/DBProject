import React, { Component } from 'react';

import Main from 'components/main';

import {
  Table,
} from 'ui';

const UserModel = {
  name: { type: String },
  phone: { type: Number },
  address: { type: String },
  staff: { type: Number,
    title: 'Number of staff' },
  inventories: { type: Number,
    title: 'Number of inventories' },
};

const users = [
  {
    name: 'Test Name 100',
    phone: '+48 234 234 234',
    address: 'Poland',
    staff: 20,
    inventories: 100,
  },
  {
    name: 'Test Name 100',
    phone: '+48 234 234 234',
    address: 'Poland',
    staff: 20,
    inventories: 100,
  },
  {
    name: 'Test Name 100',
    phone: '+48 234 234 234',
    address: 'Poland',
    staff: 20,
    inventories: 100,
  },
];

class MovieRentals extends Component {
  render() {
    return (
      <Main>
        <Table
          model={ UserModel }
          multiSelectable={ false }
          selectable={ false }
          source={ users }
        />
      </Main>
    );
  }
}

export default MovieRentals;