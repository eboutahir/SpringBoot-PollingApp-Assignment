import { Link } from "react-router-dom";
import "./CardButton.css"

function CardButton({ title, linkTo }) {
  return (
    <>
      <Link to={linkTo}>
        <div class="card"> {title} </div>
      </Link>
    </>
  );
}

export default CardButton;
