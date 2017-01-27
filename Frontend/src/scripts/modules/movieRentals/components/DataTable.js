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
    data: PropTypes.array,
  };

  render() {
    const { data } = this.props;

    if (!data) {
      return null;
    }

    return (
      <Table multiSelectable={ false }
        selectable={ false }
      >
        <TableHead>
          <TableCell>Id</TableCell>
          <TableCell>Name</TableCell>
          <TableCell>Phone</TableCell>
          <TableCell>Street</TableCell>
          <TableCell>City</TableCell>
          <TableCell>Postal code</TableCell>
          <TableCell>Country</TableCell>
          <TableCell />
        </TableHead>
        { data.map((item, index) => {
          return (
            <TableRow key={ index }>
              <TableCell>{ item.id }</TableCell>
              <TableCell>{ item.name }</TableCell>
              <TableCell>{ item.phone }</TableCell>
              <TableCell>{ item.address.street } { item.address.streetNumber }</TableCell>
              <TableCell>{ item.address.cityName }</TableCell>
              <TableCell>{ item.address.postalCode }</TableCell>
              <TableCell>{ item.address.countryName } ({ item.address.countryCode })</TableCell>
              <TableCell>
                <Button icon="edit" onClick={ this.props.onEdit.bind(null, item.id) } floating primary mini />
                <Button icon="remove" floating primary mini />
              </TableCell>
            </TableRow>
          );
        }) }
      </Table>
    );
  }
}