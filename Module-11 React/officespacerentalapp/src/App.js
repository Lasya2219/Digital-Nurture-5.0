import image from './images/image.png'
import './App.css';

function App() {
  const office = {
    Name:"DBS",
    Rent: 50000,
    Address: "Chennai"
  }

  const offices = [

    {
        Name: "DBS",
        Rent: 50000,
        Address: "Chennai"
    },

    {
        Name: "Infosys",
        Rent: 70000,
        Address: "Hyderabad"
    },

    {
        Name: "TCS",
        Rent: 65000,
        Address: "Bangalore"
    }

  ];

  return (
    <div className="App">
      <div>
        <h1>Office Space, at Affordable Range</h1>
        <img
          src={image}
          width="25%"
          height="25%"
          alt="Office Space"
        />
        <h1>Name: {office.Name}</h1>
        <h3 style={{color: office.Rent > 60000 ? "red" : "green"}}>Rent: Rs. {office.Rent}</h3>
        <h6>Address: {office.Address}</h6>
      </div>
      <div className='offices'>
        {
          offices.map((item) => (
            <div className='office'>
              <h1>Name: {item.Name}</h1>
              <h4 style={{color: item.Rent > 60000 ? "red" : "green" }}>Rent: Rs. {item.Rent}</h4>
              <h6>Address: {item.Address}</h6>
            </div>
          ))
        }
      </div>
    </div>
  );
}

export default App;
