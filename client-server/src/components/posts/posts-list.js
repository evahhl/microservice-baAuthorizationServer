import React, { Component } from 'react';
import { NavbarToggler, NavbarText, Nav, Navbar, NavLink, Input, Button, UncontrolledCollapse, Container, Form, FormGroup } from 'reactstrap';
import { Label, CardImg, Alert, Card, CardBody, CardText, CardFooter, CardTitle, Row, Col } from 'reactstrap';
import { withTranslation } from 'react-i18next';
import { BiEditAlt } from "react-icons/bi";
import PostService from '../../services/post-service';
import AuthenticationService from '../../services/authentication-service';
import avatar from '../../images/avatar.png';
import { BsHeart } from "react-icons/bs";
import { BsHeartFill } from "react-icons/bs";
import { BsX } from "react-icons/bs";
import { BiChat } from "react-icons/bi";
import Validator from '../validator';
import $ from 'jquery';

class PostsList extends Component {

  constructor(props) {
    super(props);
    this.validator = new Validator();
    this.state = {
      pageNumber: 0,
      pageSize: 2,
      orderBy: 'dateCreated',
      showUser: false,
      showPM: false,
      showAdmin: false,
      login: false,
      open: false,
      error: ""
    };
  }

  showMorePosts = (event) => {
    var pageNumber = this.state.pageNumber;
    var pageSize = this.state.pageSize;
    pageSize = pageSize + 2;
    var totalPages = this.state.totalPages;
    const orderBy = this.state.orderBy;
    console.log('totalPages' + totalPages);
    if (totalPages == 1) {
      $('#showMorePosts').hide();
    } else {
      this.getPostsList(pageNumber, pageSize, orderBy);
    }
    this.setState({ pageNumber: pageNumber, pageSize: pageSize });

  }

  getPostsList(pageNumber, pageSize, orderBy) {
    console.log("pageNumber" + pageNumber);
    PostService.getPosts(pageNumber, pageSize, orderBy).then(posts => {
      this.setState({ posts: posts, error: "" });
      var totalPages = PostService.getTotalPages();
      this.setState({ pageNumber: pageNumber, pageSize: pageSize, totalPages: totalPages });
    }
    );
  }


  onEdit(id) {
    $('#post' + id).hide();
    $('#btEdit' + id).hide();
    $('#postEdit' + id).show();
  }

  onCancel(id) {
    $('#postEdit' + id).hide();
    $('#btEdit' + id).show();
    $('#post' + id).show();
  }

  onDelete(idPost) {
    const { t } = this.props;
    if (window.confirm(t('post.delete.confirm'))) {
      PostService.deletePost(idPost)
        .then(
          () => {
            alert(t('post.delete.ok'));
            this.onCancel(idPost)
            this.componentDidMount();
          },
          error => {
            alert(t('post.error'))
          }
        );
    }
  }

  onDeleteComment(idPost, idComment) {
    const { t } = this.props;
    if (window.confirm(t('post.comment.delete.confirm'))) {
      PostService.deleteComment(idPost, idComment)
        .then(
          () => {
            alert(t('post.comment.delete.ok'));
            this.componentDidMount();
          },
          error => {
            alert(t('post.error'))
          }
        );
    }
  }

  onLike(idPost) {
    const { t } = this.props;
    PostService.likePost(idPost)
      .then(
        () => {
          this.componentDidMount();
        },
        error => {
          alert(t('post.error'))
        }
      );
  }

  onUnlike(idPost) {
    const { t } = this.props;
    PostService.unlikePost(idPost)
      .then(
        () => {
          this.componentDidMount();
        },
        error => {
          alert(t('post.error'))
        }
      );
  }

  onComment(idPost) {
    const { t } = this.props;
    if (this.validator.validateComment(idPost, $('#txtComment' + idPost).val())) {
      const user = AuthenticationService.getCurrentUser();
      const body = {
        'message': $('#txtComment' + idPost).val(),
        'userId': user.userInfo.userId,
        'by': user.userInfo.name,
        'likes': 0
      }
      PostService.addComment(idPost, body)
        .then(
          () => {
            $('#unToggler' + idPost).removeClass('show');
            $('#txtComment' + idPost).val('');
            this.componentDidMount();
          },
          error => {
            alert(t('post.error'))
          }
        );
    }
  }

  onChangePost(idPost) {
    const { t } = this.props;
    if (this.validator.validatePostEdit(idPost)) {
      if (window.confirm(t('post.edit.confirm'))) {
        const user = AuthenticationService.getCurrentUser();
        const body = {
          _id: idPost,
          post: $('#inpTitle' + idPost).val(),
          description: $('#txtDescription' + idPost).val(),
          userId: user.userInfo.userId,
          by: user.userInfo.name,
          tags: [],
          likes: 0,
        };
        PostService.editPost(idPost, body)
          .then(
            () => {
              alert(t('post.edit.ok'));
              this.onCancel(idPost)
              this.componentDidMount();
            },
            error => {
              alert(t('post.error'))
            }
          );
      }
    }
  }

  componentDidMount() {
    const user = AuthenticationService.getCurrentUser();
    const roles = user.userInfo.userTypeDescription ? user.userInfo.userTypeDescription : "";

    this.getPostsList(this.state.pageNumber, this.state.pageSize, this.state.orderBy);

    this.setState({ user: user });
    this.setState({ roles: roles });
    this.setState({
      showUser: true,
      showPM: roles.includes("Auxiliar") || roles.includes("Admin"),
      showAdmin: roles.includes("Admin")
    });

  }

  render() {
    const { t } = this.props;
    var posts = this.state.posts ? this.state.posts : [];
    var user = this.state.user;

    let itemsList = posts.map(item => (

      <div className="marginBotton">
        <Card>
          <CardBody>
            <Navbar expand="md">
              <Nav>
                <CardImg src={avatar} alt="building" className="avatar" />
                <CardTitle tag="h5">{item.by}</CardTitle>
              </Nav>
              <NavbarToggler />
              {this.state.showAdmin &&
                <NavbarText className="justify-content-end">
                  <Button color="link" onClick={() => this.onEdit(item.id)} id={"btEdit" + item.id} name={"btEdit" + item.id}><BiEditAlt /></Button>
                </NavbarText>
              }
            </Navbar>
            <div id={"post" + item.id}>
              <CardText id={"ctxtTitle" + item.id} name={"ctxtTitle" + item.id}>{item.post} </CardText>
              <CardText id={"ctxtDescription" + item.id} name={"ctxtDescription" + item.id}>{item.description}</CardText>
            </div>
            <div id={"postEdit" + item.id} style={{ display: "none" }}>
              <Label for="title">{t('post.title')} </Label>
              <Input type="text" defaultValue={item.post}
                name={"inpTitle" + item.id} id={"inpTitle" + item.id}
                required />
              <div className="error" id={"errorTitle" + item.id} style={{ display: "none" }}>{t('post.error.title')}</div>
              <Label id={"lblDescription" + item.id} for="description">{t('post.description')} </Label>
              <textarea className="form-control" id={"txtDescription" + item.id} name={"txtDescription" + item.id} defaultValue={item.description} required></textarea>
              <div className="error" id={"errorDescription" + item.id} style={{ display: "none" }}>{t('post.error.description')}</div>
              <Navbar id={"nbPost" + item.id} name={"nbPost" + item.id} className="justify-content-between">
                <Input type="file" name="attachment[]" id={"attachment" + item.id} multiple="0" />
                <div>
                  <Button color="danger" size="sm" onClick={() => this.onDelete(item.id)}>
                    {t('button.delete')}
                  </Button>{' '}
                  <Button color="primary" size="sm" onClick={() => this.onChangePost(item.id)}>
                    {t('button.edit')}
                  </Button>{' '}
                  <Button color="secondary" size="sm" onClick={() => this.onCancel(item.id)}>
                    {t('button.cancel')}
                  </Button>
                </div>
              </Navbar>
            </div>
            {item.comments.map(comments => (
              <div className="listComments">
                <CardImg src={avatar} alt="building" className="avatar" />
                <div className="d-flex justify-content-between">
                  <div>{comments.by}  <br />
                    {comments.message} <br />
                    {new Intl.DateTimeFormat('en-US').format(new Date(comments.dateCreated))}
                  </div>
                  <div>
                    {comments.userId ==  user.userInfo.userId &&
                      <Button className="comments" onClick={() => this.onDeleteComment(item.id, comments.id)}><BsX /> </Button>
                    }  
                    </div>
                </div>
              </div>
            ))
            }
            <div>
              <UncontrolledCollapse toggler={"#toggler" + item.id} id={"unToggler" + item.id} >
                <Form onSubmit={this.doLogin}>
                  <FormGroup>
                    <textarea className="form-control comments" id={"txtComment" + item.id}></textarea>
                    <div className="error" id={"errorComment" + item.id} style={{ display: "none" }}>{t('post.error.comment')}</div>
                  </FormGroup>
                  <Navbar className="justify-content-center" >
                  <Button color="secondary" size="sm" onClick={() =>  $('#unToggler' + item.id).removeClass('show')}>
                    {t('button.cancel')}
                  </Button> &nbsp;
                  <Button color="primary" size="sm" onClick={() => this.onComment(item.id)}>
                      {t('button.comment')}
                    </Button>
                  </Navbar>
                </Form>
              </UncontrolledCollapse>
            </div>
          </CardBody>
          <CardFooter>
            <Container>
              <Row>
                <Col>
                  {new Intl.DateTimeFormat('en-US').format(new Date(item.dateCreated))}
                </Col>
                <Col>
                  <Button id={"toggler" + item.id} className="comments">
                    <BiChat />  {t('userPage.comment')} {item.comments.length > 0 && "(" + item.comments.length + ")"}
                  </Button>
                </Col>
                <Col>
                  {item.liked &&
                    <Button id={"btnLike" + item.id} className="comments" onClick={() => this.onUnlike(item.id)}><BsHeartFill /> </Button>
                  }
                  {!item.liked &&
                    <Button id={"btnUnLike" + item.id} className="comments" onClick={() => this.onLike(item.id)}><BsHeart /> </Button>
                  }
                  &nbsp;{item.likes > 0 ? item.likes : ""}
                </Col>
              </Row>
            </Container>
          </CardFooter>
        </Card>
      </div>
    ));

    return (
      <Container className="activity">
        <CardTitle tag="h5"><strong><br />{t('userPage.activity')}</strong></CardTitle>
        {
          this.state.error && (
            <div><Alert color="danger">
              {this.state.error}
            </Alert></div>
          )
        }
        {itemsList}
        {this.state.posts && (
          <Container id='showMorePosts' name="showMorePosts">
            <NavLink href="#" onClick={this.showMorePosts}><CardTitle tag="h6" className="text-center">{t('userPage.showMorePosts')}</CardTitle></NavLink>
          </Container>

        )}

      </Container>
    );
  }


}

export default withTranslation()(PostsList);