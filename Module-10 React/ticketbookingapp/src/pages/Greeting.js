import GuestGreeting from "./GuestGreeting";
import UserGreeting from "./UserGreeting";

function Greetings(props) {
    const isLoggedIn = props.isLoggedIn;
    if(isLoggedIn) {
        return <UserGreeting/>;
    }

    return <GuestGreeting/>;
}

export default Greetings;