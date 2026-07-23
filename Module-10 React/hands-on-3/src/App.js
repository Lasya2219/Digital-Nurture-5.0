import logo from './logo.svg';
import './App.css';
import { CalculateScore } from './Components/CalculatorScore';

function App() {
  return (
    <div className='background'>
      <CalculateScore Name={"Steeve"} School={"Army Public School"} total={284} goal={3}/>
    </div>
  );
}

export default App;
