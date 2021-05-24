import React  from 'react';
import ReactDOM from 'react-dom'

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            age: null,
            student: null,
            income: null,
            ageOptions: [],
            studentOptions: [],
            incomeOptions: [],
            products: []
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/questionnaire/options')
            .then(res => res.json())
            .then(data => {
                this.setState({
                    ageOptions: data.ageOptions,
                    studentOptions: data.studentOptions,
                    incomeOptions: data.incomeOptions,
                    age: data.ageOptions[0].name,
                    student: data.studentOptions[0].name,
                    income: data.incomeOptions[0].name
                }, this.getRecommendations);
            })
            .catch(console.log)
    }

    getRecommendations() {
        const {age, student, income} = this.state;
        const query = `?age=${age}&student=${student}&income=${income}`;

        fetch('http://localhost:8080/api/recommendations' + query)
            .then(res => res.json())
            .then(data => {
                this.setState({products: data.products});
            })
            .catch(console.log)
    }

    render() {
        return (
            <div>
                <div>
                    {this.state.products.map(product => (
                        <option key={product.name} value={product.name}>
                            {product.name}
                        </option>
                    ))}
                </div>
            </div>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('app')
)