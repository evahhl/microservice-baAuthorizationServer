import React, { Component } from 'react';
import { Nav, Navbar, NavLink } from 'reactstrap';
import { withTranslation } from 'react-i18next';

class Footer extends Component {
  
  render() {
    const { t } = this.props;
    return <Navbar>
              <Nav className="justify-content-md-center">
                <NavLink href="/" className="white">{t('footer.powered')} | </NavLink>
                <NavLink href="/" className="white">{t('footer.terms')} | </NavLink>
                <NavLink href="/" className="white">{t('footer.privacy')}</NavLink>
               </Nav>
           </Navbar>;
  }
}

export default withTranslation()(Footer);

