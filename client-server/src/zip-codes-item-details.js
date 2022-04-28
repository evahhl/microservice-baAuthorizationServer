import React, { Component } from 'react';
import './App.css';

class ZipCodesItemDetails extends Component {
  constructor(props) {
    super(props);
    this.onEdit = this.onEdit.bind(this);
    this.onDelete = this.onDelete.bind(this);
  }

  render() {
    const item = this.props.item;
    return (
      <div className="input-panel">
      <span className="form-caption">{ item.name}</span>
      <div><span className="field-name">Id:</span><br/> {item.zipCodeId}</div>
      <div><span className="field-name">Zip Code:</span><br/> {item.zipCode}</div>
      <div><span className="field-name">Neighborhood:</span><br/> {item.neighborhood}</div>
      <div><span className="field-name">Status:</span><br/> {item.status}</div>
      <div><span className="field-name">Date Created:</span><br/> {item.dateCreated}</div>
      <br/>
      <button onClick={() => this.onDelete()}>Delete</button> 
      <button onClick={() => this.onEdit()}>Edit</button>
      </div>
    );
  }
  onEdit() {
    this.props.onEdit();
  }
  onDelete() {
    const item = this.props.item;
    if(window.confirm("Are you sure to delete item: " + item.name + " ?")) {
      this.props.onDelete(item.link);
    }
  }
  
}

export default ZipCodesItemDetails;
