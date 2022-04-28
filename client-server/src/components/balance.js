import React, { Component } from 'react';
import { Nav} from 'reactstrap';
import { NavLink,  CardTitle, Col } from 'reactstrap';
import { withTranslation } from 'react-i18next';

class Balance extends Component {

  render() {
    const { t } = this.props;
    return (
      <Col className="content leftrigthprofile d-none d-lg-block">
        <Nav>
          <CardTitle tag="h6">{t('infoBalance.currentBalance')}</CardTitle>
        </Nav>
        <Nav>
          <CardTitle tag="h6">$ 0</CardTitle>
        </Nav>
        <Nav>
          <NavLink href="/user">{t('infoBalance.viewDetails')}</NavLink>
        </Nav>
        <Nav>                      
          <CardTitle tag="h6">{t('infoBalance.serviceRequests')}</CardTitle>
        </Nav>
        <Nav>
            <CardTitle tag="h6">0</CardTitle>
        </Nav>
        <Nav>
          <NavLink href="/user">{t('infoBalance.viewDetails')}</NavLink>
        </Nav>
      </Col>         
    );
  }
}

export default withTranslation()(Balance);