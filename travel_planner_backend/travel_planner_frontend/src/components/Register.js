import { Button, Form, Input, message, Modal } from 'antd';
import React from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { register } from '../utils/auth';
 
class Register extends React.Component {
  state = {
    displayModal: false
  }
 
  onFinish = (data) => {
    register(data)
      .then(() => {
        this.setState({
          displayModal: false,
        })
        message.success(`Successfully signed up`);
      }).catch((err) => {
        message.error(err.message);
      })
  }
 
  render = () => {
    return (
      <div>
        <h1>RegisterPage</h1>
        <Form
            name="normal_register"
            initialValues={{ remember: true }}
            onFinish={this.onFinish}
            preserve={false}
          >
          <Form.Item
              name="username"
              rules={[{ required: true, message: 'Please input your Username!' }]}
          >
            <Input prefix={<UserOutlined />} placeholder="username" />
          </Form.Item>

            <Form.Item
              name="email"
              rules={[{ required: true, message: 'Please input your Email !' }]}
            >
              <Input prefix={<UserOutlined />} placeholder="email" />
            </Form.Item>
            <Form.Item
              name="password"
              rules={[{ required: true, message: 'Please input your Password!' }]}
            >
              <Input
                prefix={<LockOutlined />}
                placeholder="Password"
              />
            </Form.Item>
            <Form.Item
              name="gender"
              rules={[{ required: true, message: 'Please input your gender!' }]}
            >
              <Input
                placeholder="gender"
              />
            </Form.Item>
            <Form.Item
              name="dateOfBirth"
              rules={[{ required: true, message: 'Please input your date of birth!' }]}
            >
              <Input
                placeholder="date birth"
              />
            </Form.Item>
            <Form.Item>
              <Button type="primary" htmlType="submit">
                Register</Button>
            </Form.Item>
          </Form>
      </div>
    )
  }
}
 
export default Register;
