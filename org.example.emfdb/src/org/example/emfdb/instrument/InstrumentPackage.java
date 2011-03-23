/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.example.emfdb.instrument;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.example.emfdb.instrument.InstrumentFactory
 * @model kind="package"
 * @generated
 */
public interface InstrumentPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "instrument";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://example.org/instrument";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "ab";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    InstrumentPackage eINSTANCE = org.example.emfdb.instrument.impl.InstrumentPackageImpl
            .init();

    /**
     * The meta object id for the '
     * {@link org.example.emfdb.instrument.impl.InstrumentImpl
     * <em>Instrument</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see org.example.emfdb.instrument.impl.InstrumentImpl
     * @see org.example.emfdb.instrument.impl.InstrumentPackageImpl#getInstrument()
     * @generated
     */
    int INSTRUMENT = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INSTRUMENT__ID = 0;

    /**
     * The feature id for the '<em><b>Symbol</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INSTRUMENT__SYMBOL = 1;

    /**
     * The feature id for the '<em><b>Scores</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INSTRUMENT__SCORES = 2;

    /**
     * The feature id for the '<em><b>Greeks</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INSTRUMENT__GREEKS = 3;

    /**
     * The feature id for the '<em><b>Under Price</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INSTRUMENT__UNDER_PRICE = 4;

    /**
     * The number of structural features of the '<em>Instrument</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INSTRUMENT_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '
     * {@link org.example.emfdb.instrument.impl.PortfolioImpl
     * <em>Portfolio</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.example.emfdb.instrument.impl.PortfolioImpl
     * @see org.example.emfdb.instrument.impl.InstrumentPackageImpl#getPortfolio()
     * @generated
     */
    int PORTFOLIO = 1;

    /**
     * The feature id for the '<em><b>Instruments</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PORTFOLIO__INSTRUMENTS = 0;

    /**
     * The number of structural features of the '<em>Portfolio</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PORTFOLIO_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link org.example.emfdb.instrument.impl.ScoreImpl <em>Score</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.example.emfdb.instrument.impl.ScoreImpl
     * @see org.example.emfdb.instrument.impl.InstrumentPackageImpl#getScore()
     * @generated
     */
    int SCORE = 2;

    /**
     * The feature id for the '<em><b>I</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SCORE__I = 0;

    /**
     * The feature id for the '<em><b>L</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SCORE__L = 1;

    /**
     * The feature id for the '<em><b>F</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SCORE__F = 2;

    /**
     * The feature id for the '<em><b>D</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SCORE__D = 3;

    /**
     * The number of structural features of the '<em>Score</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SCORE_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '
     * {@link org.example.emfdb.instrument.impl.GreeksImpl <em>Greeks</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.example.emfdb.instrument.impl.GreeksImpl
     * @see org.example.emfdb.instrument.impl.InstrumentPackageImpl#getGreeks()
     * @generated
     */
    int GREEKS = 3;

    /**
     * The feature id for the '<em><b>Price</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int GREEKS__PRICE = 0;

    /**
     * The feature id for the '<em><b>Delta</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int GREEKS__DELTA = 1;

    /**
     * The feature id for the '<em><b>Gamma</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int GREEKS__GAMMA = 2;

    /**
     * The feature id for the '<em><b>Vega</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int GREEKS__VEGA = 3;

    /**
     * The feature id for the '<em><b>Theta</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int GREEKS__THETA = 4;

    /**
     * The feature id for the '<em><b>Rho</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int GREEKS__RHO = 5;

    /**
     * The number of structural features of the '<em>Greeks</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int GREEKS_FEATURE_COUNT = 6;

    /**
     * Returns the meta object for class '
     * {@link org.example.emfdb.instrument.Instrument <em>Instrument</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Instrument</em>'.
     * @see org.example.emfdb.instrument.Instrument
     * @generated
     */
    EClass getInstrument();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Instrument#getId <em>Id</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.example.emfdb.instrument.Instrument#getId()
     * @see #getInstrument()
     * @generated
     */
    EAttribute getInstrument_Id();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Instrument#getSymbol <em>Symbol</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Symbol</em>'.
     * @see org.example.emfdb.instrument.Instrument#getSymbol()
     * @see #getInstrument()
     * @generated
     */
    EAttribute getInstrument_Symbol();

    /**
     * Returns the meta object for the reference list '
     * {@link org.example.emfdb.instrument.Instrument#getScores <em>Scores</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Scores</em>'.
     * @see org.example.emfdb.instrument.Instrument#getScores()
     * @see #getInstrument()
     * @generated
     */
    EReference getInstrument_Scores();

    /**
     * Returns the meta object for the reference '
     * {@link org.example.emfdb.instrument.Instrument#getGreeks <em>Greeks</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Greeks</em>'.
     * @see org.example.emfdb.instrument.Instrument#getGreeks()
     * @see #getInstrument()
     * @generated
     */
    EReference getInstrument_Greeks();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Instrument#getUnderPrice
     * <em>Under Price</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Under Price</em>'.
     * @see org.example.emfdb.instrument.Instrument#getUnderPrice()
     * @see #getInstrument()
     * @generated
     */
    EAttribute getInstrument_UnderPrice();

    /**
     * Returns the meta object for class '
     * {@link org.example.emfdb.instrument.Portfolio <em>Portfolio</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Portfolio</em>'.
     * @see org.example.emfdb.instrument.Portfolio
     * @generated
     */
    EClass getPortfolio();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.example.emfdb.instrument.Portfolio#getInstruments
     * <em>Instruments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Instruments</em>'.
     * @see org.example.emfdb.instrument.Portfolio#getInstruments()
     * @see #getPortfolio()
     * @generated
     */
    EReference getPortfolio_Instruments();

    /**
     * Returns the meta object for class '
     * {@link org.example.emfdb.instrument.Score <em>Score</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Score</em>'.
     * @see org.example.emfdb.instrument.Score
     * @generated
     */
    EClass getScore();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Score#getI <em>I</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>I</em>'.
     * @see org.example.emfdb.instrument.Score#getI()
     * @see #getScore()
     * @generated
     */
    EAttribute getScore_I();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Score#getL <em>L</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>L</em>'.
     * @see org.example.emfdb.instrument.Score#getL()
     * @see #getScore()
     * @generated
     */
    EAttribute getScore_L();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Score#getF <em>F</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>F</em>'.
     * @see org.example.emfdb.instrument.Score#getF()
     * @see #getScore()
     * @generated
     */
    EAttribute getScore_F();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Score#getD <em>D</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>D</em>'.
     * @see org.example.emfdb.instrument.Score#getD()
     * @see #getScore()
     * @generated
     */
    EAttribute getScore_D();

    /**
     * Returns the meta object for class '
     * {@link org.example.emfdb.instrument.Greeks <em>Greeks</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Greeks</em>'.
     * @see org.example.emfdb.instrument.Greeks
     * @generated
     */
    EClass getGreeks();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Greeks#getPrice <em>Price</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Price</em>'.
     * @see org.example.emfdb.instrument.Greeks#getPrice()
     * @see #getGreeks()
     * @generated
     */
    EAttribute getGreeks_Price();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Greeks#getDelta <em>Delta</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Delta</em>'.
     * @see org.example.emfdb.instrument.Greeks#getDelta()
     * @see #getGreeks()
     * @generated
     */
    EAttribute getGreeks_Delta();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Greeks#getGamma <em>Gamma</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Gamma</em>'.
     * @see org.example.emfdb.instrument.Greeks#getGamma()
     * @see #getGreeks()
     * @generated
     */
    EAttribute getGreeks_Gamma();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Greeks#getVega <em>Vega</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Vega</em>'.
     * @see org.example.emfdb.instrument.Greeks#getVega()
     * @see #getGreeks()
     * @generated
     */
    EAttribute getGreeks_Vega();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Greeks#getTheta <em>Theta</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Theta</em>'.
     * @see org.example.emfdb.instrument.Greeks#getTheta()
     * @see #getGreeks()
     * @generated
     */
    EAttribute getGreeks_Theta();

    /**
     * Returns the meta object for the attribute '
     * {@link org.example.emfdb.instrument.Greeks#getRho <em>Rho</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Rho</em>'.
     * @see org.example.emfdb.instrument.Greeks#getRho()
     * @see #getGreeks()
     * @generated
     */
    EAttribute getGreeks_Rho();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    InstrumentFactory getInstrumentFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that
     * represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '
         * {@link org.example.emfdb.instrument.impl.InstrumentImpl
         * <em>Instrument</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see org.example.emfdb.instrument.impl.InstrumentImpl
         * @see org.example.emfdb.instrument.impl.InstrumentPackageImpl#getInstrument()
         * @generated
         */
        EClass INSTRUMENT = eINSTANCE.getInstrument();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute INSTRUMENT__ID = eINSTANCE.getInstrument_Id();

        /**
         * The meta object literal for the '<em><b>Symbol</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute INSTRUMENT__SYMBOL = eINSTANCE.getInstrument_Symbol();

        /**
         * The meta object literal for the '<em><b>Scores</b></em>' reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference INSTRUMENT__SCORES = eINSTANCE.getInstrument_Scores();

        /**
         * The meta object literal for the '<em><b>Greeks</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference INSTRUMENT__GREEKS = eINSTANCE.getInstrument_Greeks();

        /**
         * The meta object literal for the '<em><b>Under Price</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute INSTRUMENT__UNDER_PRICE = eINSTANCE
                .getInstrument_UnderPrice();

        /**
         * The meta object literal for the '
         * {@link org.example.emfdb.instrument.impl.PortfolioImpl
         * <em>Portfolio</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @see org.example.emfdb.instrument.impl.PortfolioImpl
         * @see org.example.emfdb.instrument.impl.InstrumentPackageImpl#getPortfolio()
         * @generated
         */
        EClass PORTFOLIO = eINSTANCE.getPortfolio();

        /**
         * The meta object literal for the '<em><b>Instruments</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference PORTFOLIO__INSTRUMENTS = eINSTANCE
                .getPortfolio_Instruments();

        /**
         * The meta object literal for the '
         * {@link org.example.emfdb.instrument.impl.ScoreImpl <em>Score</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.example.emfdb.instrument.impl.ScoreImpl
         * @see org.example.emfdb.instrument.impl.InstrumentPackageImpl#getScore()
         * @generated
         */
        EClass SCORE = eINSTANCE.getScore();

        /**
         * The meta object literal for the '<em><b>I</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SCORE__I = eINSTANCE.getScore_I();

        /**
         * The meta object literal for the '<em><b>L</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SCORE__L = eINSTANCE.getScore_L();

        /**
         * The meta object literal for the '<em><b>F</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SCORE__F = eINSTANCE.getScore_F();

        /**
         * The meta object literal for the '<em><b>D</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SCORE__D = eINSTANCE.getScore_D();

        /**
         * The meta object literal for the '
         * {@link org.example.emfdb.instrument.impl.GreeksImpl <em>Greeks</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see org.example.emfdb.instrument.impl.GreeksImpl
         * @see org.example.emfdb.instrument.impl.InstrumentPackageImpl#getGreeks()
         * @generated
         */
        EClass GREEKS = eINSTANCE.getGreeks();

        /**
         * The meta object literal for the '<em><b>Price</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute GREEKS__PRICE = eINSTANCE.getGreeks_Price();

        /**
         * The meta object literal for the '<em><b>Delta</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute GREEKS__DELTA = eINSTANCE.getGreeks_Delta();

        /**
         * The meta object literal for the '<em><b>Gamma</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute GREEKS__GAMMA = eINSTANCE.getGreeks_Gamma();

        /**
         * The meta object literal for the '<em><b>Vega</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute GREEKS__VEGA = eINSTANCE.getGreeks_Vega();

        /**
         * The meta object literal for the '<em><b>Theta</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute GREEKS__THETA = eINSTANCE.getGreeks_Theta();

        /**
         * The meta object literal for the '<em><b>Rho</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute GREEKS__RHO = eINSTANCE.getGreeks_Rho();

    }

} // InstrumentPackage
