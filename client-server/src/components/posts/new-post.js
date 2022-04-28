import React  from 'react';
import { Formik, ErrorMessage} from 'formik';
import { Navbar, Alert, Input, Button, Form, FormGroup, Label,  CardTitle } from 'reactstrap';
import PostService from '../../services/post-service';
import AuthenticationService from '../../services/authentication-service';
import { useTranslation } from 'react-i18next';

function MyComponent() {
    const { t } = useTranslation();
    return (    
        <div>
          <Formik
            initialValues={{ inpTitle: '', txtDescription: '', errorResult:false }}
            validate={values => {
              const errors = {};
              if (!values.inpTitle) {
                errors.inpTitle = t('post.error.title');
              } 
              if (!values.txtDescription) {
                errors.txtDescription = t('post.error.description');                
              } 

              return errors;
            }}
            onSubmit={(values, { setSubmitting }) => {
                const user = AuthenticationService.getCurrentUser();  
                const body = { 
                    'post': values.inpTitle,
                    'description': values.txtDescription,
                    'userId': user.userInfo.userId,
                    'by': user.userInfo.name + " " + user.userInfo.lastName,
                    'tags': [],
                    'likes': 0,
                 };

                 PostService.createPost(body)
                .then(
                 () => {
                    setTimeout(() => {
                        setSubmitting(true);                                         
                        window.location.reload();    
                      }, 1000);
                 },
                 error => {   
                  values.errorResult = true;   
                  setSubmitting(false);    
                 }
             );                
            }}
          >
            {({
              values,
              errors,
              handleChange,
              handleSubmit,
              isSubmitting,
              /* and other goodies */
            }) => (          
              <Form className="newPost" onSubmit={handleSubmit}>
              <FormGroup>
                  <CardTitle tag="h6"><b>{t('userPage.post')}</b></CardTitle>
                  <Label for="inpTitle">{t('post.title')} </Label>
                  <Input autoFocus type="text"
                      name="inpTitle" id="inpTitle" bsSize="10px"
                      value={values.inpTitle}
                      autoComplete="title"
                      onChange={handleChange}    
                      className={errors.inpTitle ?'borderError':''}/>
                  <ErrorMessage name="inpTitle" component="div" className="error"/>
                  <Label for="txtDescription">{t('post.description')} </Label><br/>
                  <textarea name="txtDescription" id="txtDescription" rows="3"  
                   value={values.txtDescription}
                   onChange={handleChange} 
                   className={errors.txtDescription ?'form-control borderError':'form-control'}/>
                   <ErrorMessage name="txtDescription" component="div" className="error"/>
              </FormGroup>
              <Navbar className="justify-content-between">
                  <Input type="file" name="attachment[]" id="attachment-0" multiple="0"/>
                  <Button color="primary" size="sm" type="submit">
                  {t('button.post')}
                  </Button>
              </Navbar>
              <p></p>
              {!values.errorResult && isSubmitting && (
                   <div><Alert color="success">{t('post.new.ok')}</Alert></div>
               )}
               <p></p>
              {values.errorResult && (
                   <div><Alert color="danger">{t('post.error')}</Alert></div>
               )}
            </Form>
            )}
          </Formik>
        </div>
    );         
}


// i18n translations might still be loaded by the http backend
// use react's Suspense
export default function App() {
    return (
        <MyComponent />
    );
  }