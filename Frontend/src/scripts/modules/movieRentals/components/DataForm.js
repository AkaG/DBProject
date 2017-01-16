import React, { Component, PropTypes } from 'react';

import { Input } from 'ui';

export default class DataForm extends Component {
  static propTypes = {
    data: PropTypes.object,
    handleChange: PropTypes.func,
  };

  onChange(field, value, event) {
    if (this.props.handleChange) {
      this.props.handleChange(field, value, event);
    }
  }

  render() {
    const {
      data,
      handleChange,
    } = this.props;

    return (
      <section>
        <Input type="text" label="Name" name="name" value={ data.name } onChange={ handleChange.bind(this, 'name') } maxLength={ 16 } />
        <Input type="text" label="Phone" name="phone" value={ data.phone } onChange={ handleChange.bind(this, 'phone') } maxLength={ 16 } />
        <Input type="text" label="Address" name="address" value={ data.address } onChange={ handleChange.bind(this, 'address') } maxLength={ 16 } />
        <Input type="text" label="Staff" name="staff" value={ data.staff } onChange={ handleChange.bind(this, 'staff') } maxLength={ 16 } />
        <Input type="text" label="Inventories" name="inventories" value={ data.inventories } onChange={ handleChange.bind(this, 'inventories') } maxLength={ 16 } />
      </section>
    );
  }
}