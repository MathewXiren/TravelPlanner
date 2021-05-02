import { Button, Form, Input, message, Modal } from 'antd';
import React from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { login } from '../utils/auth';
 
const Login = (props) =>  {

  const onFinish = (data) => {
    console.log(data);
    login(data)
      .then((data) => {
        message.success(`Welcome back`);
        props.onSuccess(true, data);
      }).catch((err) => {
        console.log(err);
        message.error(err.message);
      })
  }

  return (
      <div className="login">
        <h1>Login</h1>
        <form name="normal_login" onSubmit={onFinish}>
            <label>
              Username:
            <input name="username" type="text"/>
            </label>
            <label>
              Password:
              <input name="password" type='text'/>
            </label>
            <button className="login-btn" type="submit">Login</button>
        </form>
        {/* <Form
          name="normal_login"
          onFinish={onFinish}
          preserve={false}
        >
          <Form.Item
            name="username"
            rules={[{ required: true, message: 'Please input your Username!' }]}
          >
            <Input prefix={<UserOutlined />} placeholder="Username" />
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

          <Form.Item>
            <Button className="login-btn" shape="round" type="primary" htmlType="submit">
              Login</Button>
          </Form.Item>
        </Form> */}
      </div>
  )

}
 
export default Login;
