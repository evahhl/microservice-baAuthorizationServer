import React, { Component } from 'react';
import { Formik, ErrorMessage} from 'formik';
import { Container } from 'reactstrap';
import { CardImg,  Navbar, Form, Alert, FormGroup, Input, Label, Row, Col, Button } from "reactstrap";
import AuthenticationService from '../services/authentication-service';
import Footer from './footer';
import { withTranslation } from 'react-i18next';
import logo from '../images/logo.jpg';
import '../App.css';

class Login extends Component {

  

  render() {
    const { t} = this.props;

    const onChangeLanguage =  () => {
      const { i18n} = this.props;
      console.log(i18n.language);
      if(i18n.language==='en'){
        i18n.changeLanguage('es');        
      }else{
        i18n.changeLanguage('en');
      }
      withTranslation()(Login);
    }

    return ( 
      <div>
       <Navbar color="dark" dark className="justify-content-end">
            <Button color="link" onClick={onChangeLanguage}>
            {t('language')}
            </Button>
        </Navbar>
        <div className="header">
          <CardImg  img="true" src = {logo} className='logo' alt="buildingAdmin" />
          <h1 className='App-header'>{t('buildingAdmin')}  </h1>
        </div> 
        <Container fluid >
          <Row style={{marginTop:"20px"}}>
          <Col>
            <div className="login">
              <div className="loginForm" align="center">   
                <Formik
                    initialValues={{ username: '', password: '', errorResult:false }}
                    validate={values => {
                    const errors = {};
                    if (!values.username) {
                        errors.username = t('login.error.username');
                    } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.username)) {
                        errors.username = t('login.error.invalid');
                    } 
                    
                    if (!values.password) {
                        errors.password = t('login.error.password');                
                    } 

                    return errors;
                    }}
                    onSubmit={(values, { setSubmitting }) => {
                        AuthenticationService
                            .signin(values.username, 
                                values.password)
                          .then(
                            () => {
                              this.props.history.push('/user');
                            },
                            error => {
                              console.log("Login fail: error = { " + error.toString() + " }");
                              values.errorResult = true;   
                            }
                        );
                    }}
                >
                    {({
                    values,
                    errors,
                    handleChange,
                    handleBlur,
                    handleSubmit
                    /* and other goodies */
                    }) => (             
                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                      <p><Label for="username">{t('login.email')} </Label></p>
                      <Input autoFocus 
                        type="text"
                        name="username" id="username"
                        value={values.username}
                        placeholder={t('login.email')}
                        autoComplete="username"
                        onChange={handleChange}
                        className={errors.username ?'borderError':''}/>
                      <ErrorMessage name="username" component="div" className="error"/><br/>
                    </FormGroup>
                    <FormGroup>
                      <p><Label for="password">{t('login.password')} </Label></p>
                      <Input type="password" 
                          name="password" id="password"
                          value={values.password}
                          placeholder={t('login.password')}
                          autoComplete="password"
                          onChange={handleChange}
                          onBlur={handleBlur}
                          className={errors.password ?'borderError':''}/>  
                      <ErrorMessage name="password" component="div" className="error"/><br/>
                    </FormGroup>
                    <div className="marginBotton">
                      <a href="/forgot-password" className="forgot-password r-text-primary">{t('login.forgotPassword')}</a>
                    </div>
                    <div  className="marginBotton">
                        <Button color="primary" type="submit">
                      {t('login')} 
                      </Button>
                    </div>
                    
                    <br/>
                    {
                      values.errorResult  && (
                        <div> <Alert color="danger">
                          {t('login.error')} 
                        </Alert></div>
                      )
                    }
                </Form>
                )}
                </Formik>
              </div>
            </div>
            </Col>
          </Row>
        </Container>
        <Footer/>
      </div>     
    );
  }
}

export default withTranslation()(Login);