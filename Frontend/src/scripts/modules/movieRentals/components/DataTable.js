import React, { Component, PropTypes } from 'react';

import {
  Button,
} from 'ui';

import {
  Table,
  TableHead,
  TableRow,
  TableCell,
} from 'ui/table';

export default class DataTable extends Component {
  static propTypes = {
    data: PropTypes.array.isRequired,
  };

  render() {
    const { data } = this.props;

    return (
      <Table multiSelectable={ false }
        selectable={ false }
      >
        <TableHead>
          <TableCell>Name</TableCell>
          <TableCell>Phone</TableCell>
          <TableCell>Address</TableCell>
          <TableCell>Staff</TableCell>
          <TableCell>Inventories</TableCell>
          <TableCell />
        </TableHead>
        { data.map((item, index) => {
          return (
            <TableRow key={ index }>
              <TableCell>{ item.name }</TableCell>
              <TableCell>{ item.phone }</TableCell>
              <TableCell>{ item.address }</TableCell>
              <TableCell>{ item.staff }</TableCell>
              <TableCell>{ item.inventories }</TableCell>
              <TableCell>
                <Button icon="edit" floating primary mini />
                <Button icon="remove" floating primary mini />
              </TableCell>
            </TableRow>
          );
        }) }
      </Table>
    );
  }
}