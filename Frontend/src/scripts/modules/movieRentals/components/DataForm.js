import React, { Component, PropTypes } from 'react';

import { Input } from 'ui';

export default class DataForm extends Component {
  static propTypes = {
    data: PropTypes.object,
  };

  constructor() {
    super();

    this.state = {
      data: {
        name: '',
        phone: '',
        address: '',
        staff: 0,
        inventories: 0,
      },
    };
  }

  onChange(name, value) {
    this.setState({
      data: {
        ...this.state.data,
        [name]: value,
      },
    });
  }

  componentWillReceiveProps(nextProps) {
    this.setState({
      data: nextProps.data,
    });
  }

  render() {
    const {
      data,
    } = this.state;

    return (
      <section>
        <Input type="text" label="Name" name="name" value={ data.name } onChange={ this.onChange.bind(this, 'name') } maxLength={ 16 } />
        <Input type="text" label="Phone" name="phone" value={ data.phone } onChange={ this.onChange.bind(this, 'phone') } maxLength={ 16 } />
        <Input type="text" label="Address" name="address" value={ data.address } onChange={ this.onChange.bind(this, 'address') } maxLength={ 16 } />
        <Input type="text" label="Staff" name="staff" value={ data.staff } onChange={ this.onChange.bind(this, 'staff') } maxLength={ 16 } />
        <Input type="text" label="Inventories" name="inventories" value={ data.inventories } onChange={ this.onChange.bind(this, 'inventories') } maxLength={ 16 } />
      </section>
    );
  }
}