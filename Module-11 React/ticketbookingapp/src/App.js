import './App.css';
import { useState } from 'react';
import Greetings from './pages/Greeting';
import LogoutButton from './components/LogoutButton';
import LoginButton from './components/LoginButton';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    setIsLoggedIn(true);
  }

  const handleLogOut = () => {
    setIsLoggedIn(false);
  }

  let button;
  if(isLoggedIn) {
    button = <LogoutButton onClick={handleLogOut}/>
  } else {
    button = <LoginButton onClick={handleLogin}/>
  }

  return (
    <div className="App">
      <div className='component'>
        <Greetings isLoggedIn={isLoggedIn}/>
        {button}
      </div>
    </div>
  );
}

export default App;
